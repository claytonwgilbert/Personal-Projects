USE `full-stack-ecommerce`;

SET FOREIGN_KEY_CHECKS=0;

TRUNCATE customer;
TRUNCATE orders;
TRUNCATE order_item;
TRUNCATE address;

SET FOREIGN_KEY_CHECKS=1;

-- Only unique email addresses can be added or error is thrown --
ALTER TABLE customer ADD UNIQUE(email); 
