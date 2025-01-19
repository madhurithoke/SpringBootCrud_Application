Spring Boot CRUD: Product and Category Management

Overview:
This project is a CRUD (Create, Read, Update, Delete) application built using Spring Boot. It manages products and their respective categories with a relational database. Each product belongs to a category, and each category can have multiple products.The project demonstrates the use of key Spring Boot components, including controllers, services, repositories, and JPA for database interactions.



API Endpoints:
    *Category Endpoints:
    GET /api/categories - Retrieve all categories (paginated).
    GET /api/categories/{id} - Retrieve category by ID.
    POST /api/categories - Create a new category.
    PUT /api/categories/{id} - Update an existing category.
    DELETE /api/categories/{id} - Delete a category.

    *Product Endpoints:
    GET /api/products - Retrieve all products (paginated).
    GET /api/products/{id} - Retrieve product by ID.
    POST /api/products - Create a new product.
    PUT /api/products/{id} - Update an existing product.
    DELETE /api/products/{id} - Delete a product
