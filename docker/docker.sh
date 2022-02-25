#!/bin/bash

SERVICE="cv"
PROFILE=""

function print_usage() {
  /bin/cat <<EOF

	Usage :
	    $0 [ -p profile ] [ -h ] [ -help ]
	Option :
	    -p, --profile       profile
	    -h, --help          print usages


EOF
}

while (("$#")); do
  case "$1" in
  -p | --profile)
    if [ -n "$2" ] && [ ${2:0:1} != "-" ]; then
      PROFILE=$2
      shift 2
    else
      echo "Error: Argument for $1 is missing" >&2
      exit 1
    fi
    ;;
  -h | --help)
    print_usage
    exit 1
    ;;
  *)
    echo "Error: Arguments with not proper flag: $1" >&2
    echo "$0 -h for help message" >&2
    print_usage
    exit 1
    ;;
  esac
done

if [[ -z "$PROFILE" ]]; then
  echo "try   bash $0 -h"
  exit 1
fi

while true; do
  echo "Current Params => PROFILE : $PROFILE"
  read -p "Do you wish to restart ${SERVICE}? (y/n) " yn
  case $yn in
  [Yy]*) break ;;
  [Nn]*) exit ;;
  *) echo "Please answer yes or no." ;;
  esac
done

RED='\033[0;31m'
NOCOLOR='\033[0m'

CONTAINER_ID=$(sudo docker ps -a -f "name=${SERVICE}" -q)
if [ -z "$CONTAINER_ID" ]; then
  echo "Nothing!"
else
  echo "Container kill"
  sudo docker commit -a "toast1ng" -m "lastVersion" ${SERVICE} toast1ng/${SERVICE}:last
  sudo docker container kill $CONTAINER_ID
  sudo docker container rm $CONTAINER_ID
fi

echo -e "\n\nClean Docker Volume"
{
  yes | sudo docker volume prune
} || echo -e "${RED}CLEAN DOCKER VOLUME FAILS${NOCOLOR}"

echo -e "\n\nRun Docker"
{
  cd /home/ubuntu/${SERVICE}
  sudo docker build -f Dockerfile toast1ng/${SERVICE}:v0.1 .
}

{
  sudo docker run -it -d -e PROFILE=${PROFILE} -p 8080:8080 -v /home/ubuntu/cv/log:/log --name ${SERVICE} toast1ng/${SERVICE}:v0.1
} || echo -e "${RED}RUNNING DOCKER FAILS${NOCOLOR}"
