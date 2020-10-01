--Table brand script
CREATE TABLE IF NOT EXISTS BRAND(
id int NOT NULL,
description  VARCHAR(30) NOT NULL
);
--Table product script
CREATE TABLE IF NOT EXISTS PRODUCT(
id int NOT NULL,
description  VARCHAR(30) NOT NULL
);
--Table currency script
CREATE TABLE IF NOT EXISTS CURRENCY(
id VARCHAR(5) NOT NULL,
description  VARCHAR(5) NOT NULL
);
--Table prices script
CREATE TABLE IF NOT EXISTS PRICES (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    BRAND_ID int NOT NULL,
    START_DATE timestamp,
    END_DATE timestamp,
    PRICE_LIST int NOT NULL default 0,
    PRODUCT_ID int NOT NULL,
    PRIORITY int NOT NULL,
    PRICE decimal NOT NULL,
    CURR VARCHAR(5) NOT NULL,
    CONSTRAINT FK_brand_id FOREIGN KEY (BRAND_ID) references BRAND (id),
    CONSTRAINT FK_product_id FOREIGN KEY (PRODUCT_ID) references PRODUCT (id),
    CONSTRAINT FK_currency FOREIGN KEY (CURR) references CURRENCY (id)
);
commit;