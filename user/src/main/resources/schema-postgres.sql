DROP TABLE IF EXISTS merchandise_products;

CREATE TABLE merchandise_products (
  id SERIAL PRIMARY KEY,
  product_name VARCHAR(30),
  price  numeric,
  bar_code numeric,
  description VARCHAR(4000),
  merchandise_category VARCHAR(60),
  availability VARCHAR(12),
  shipping_cost numeric,
  image_url VARCHAR(1000),
  bundle VARCHAR(1000),
  featured VARCHAR(1)
);