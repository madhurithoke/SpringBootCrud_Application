Spring Boot CRUD: Product and Category Management

Overview:
This project is a CRUD (Create, Read, Update, Delete) application built using Spring Boot. It manages products and their respective categories with a relational database. Each product belongs to a category, and each category can have multiple products.The project demonstrates the use of key Spring Boot components, including controllers, services, repositories, and JPA for database interactions.

Entity Relationships:
    *Category:
    Represents a category of products.
    Fields: id (Primary Key), name, and products (One-to-Many relationship with Product).

    *Product:
    Represents a product belonging to a category.
    Fields: id (Primary Key), name, price, and category (Many-to-One relationship with Category).

Features:
    *Category Management:
        Create a new category.
        Update category details.
        Fetch category by ID.
        Fetch all categories with pagination.
        Delete a category.

    *Product Management:
        Create a new product under a specific category.
        Update product details.
        Fetch product by ID.
        Fetch all products with pagination.
        Delete a product.

Working Mechanism:
    *Controllers:
    Handle HTTP requests and return responses.
    Use service layer methods to perform business logic.
    Example: CategoryController and ProductController.

    *Services:
    Contain business logic for the application.
    Abstract database operations from controllers.
    Example: CategoryServiceImpl and ProductServiceImpl.

    *Repositories:
    Provide data access using Spring Data JPA.
    Example: CategoryRepository and ProductRepository.

    *Models:
    Map database tables to Java objects.
    Example: Category and Product.

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
