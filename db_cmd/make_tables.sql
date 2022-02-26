-- Drop table if exists `history`;
Create table `history`
(
    `history_id`       int          NOT NULL,
    `type`             varchar(255) NOT NULL,
    `name`             varchar(255) NOT NULL,
    `description`      varchar(255) NOT NULL,
    `more_description` varchar(255) NOT NULL,
    PRIMARY KEY (`history_id`)
);

-- Drop table if exists `information`;
Create table `information`
(
    `information_id`  int          NOT NULL,
    `category`        varchar(255) NOT NULL,
    `description`     varchar(255) NOT NULL,
    `greeting_or_not` tinyint      NOT NULL,
    PRIMARY KEY (`information_id`)
);

-- Drop table if exists `tech_stack`;
Create table `tech_stack`
(
    `tech_stack_id` int          NOT NULL,
    `description`   text NOT NULL,
    PRIMARY KEY (`tech_stack_id`)
);

-- Drop table if exists `things_done`;
Create table `things_done`
(
    `things_done_id` int          NOT NULL,
    `era`            varchar(255) NOT NULL,
    `category`       varchar(255) NOT NULL,
    `description`    text NOT NULL,
    PRIMARY KEY (`things_done_id`)
);