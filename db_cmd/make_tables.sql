-- Drop table if exists `awards`;
Create table `awards`
(
    `award_id`    int,
    `award_name`  varchar(255),
    `description` varchar(255),
    `award`       varchar(255),
    PRIMARY KEY (`award_id`)
);

-- Drop table if exists `career`;
Create table `career`
(
    `career_id`    int,
    `company_name` varchar(255),
    `description`  varchar(255),
    `start_date`   datetime,
    `end_date`     datetime,
    `current_work_or_not` tinyint,
    PRIMARY KEY (`career_id`)
);

-- Drop table if exists `education_history`;
Create table `education_history`
(
    `education_id` int,
    `school_name`  varchar(255),
    `description`  varchar(255),
    `start_date`   datetime,
    `end_date`     datetime,
    PRIMARY KEY (`education_id`)
);

-- Drop table if exists `information`;
Create table `information`
(
    `information_id`  int,
    `category`        varchar(255),
    `description`     varchar(255),
    `greeting_or_not` tinyint,
    PRIMARY KEY (`information_id`)
);

-- Drop table if exists `tech_stack`;
Create table `tech_stack`
(
    `tech_stack_id` int,
    `description`   varchar(255),
    PRIMARY KEY (`tech_stack_id`)
);

-- Drop table if exists `things_done`;
Create table `things_done`
(
    `things_done_id` int,
    `era`            varchar(255),
    `category`       varchar(255),
    `description`    varchar(255),
    PRIMARY KEY (`things_done_id`)
);