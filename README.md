
# Spring Boot CRUD Application

This is a Spring Boot-based CRUD application that manages **categories** and **products**. It supports various endpoints to perform operations like creating, reading, updating, and deleting records. Below is the detailed overview of the project structure, relationships, API endpoints, and working mechanism

## Project Structure

### **1. Controller Layer**
- **Files**:
  - CategoryController.java - Handles HTTP requests for categories.
  - ProductController.java  - Handles HTTP requests for products.

### **2. Service Layer**
- **Files**:
  - CategoryServiceI.java and CategoryServiceImpl.java - Business logic for categories.
  - ProductServiceI.java and ProductServiceImpl.java  - Business logic for products.

### **3. Repository Layer**
- **Files**:
  - CategoryRepository.java - Database operations for categories.
  - ProductRepository.java - Database operations for products.

### **4. Model Layer**
- **Files**:
  - Category.java - Represents the category entity.
  - Product.java  - Represents the product entity

## Database Relationships
- **Category**:
  - Has a one-to-many relationship with **Product**.
  - A category can contain multiple products.

- **Product**:
  - Has a many-to-one relationship with **Category**.
  - A product belongs to one category.


## API Endpoints

### **Category Endpoints**

#### **1. Create Category**
- **Method**: POST
- **Endpoint**: /api/categories
- **Body (Raw JSON)**:
  ```json
  {
    "cname": "Electronics"
  }
  ```
- **Response**:
  ```json
  {
    "cid": 1,
    "cname": "Electronics"
  }
  ```

#### **2. Get All Categories**
- **Method**: GET
- **Endpoint**: /api/categories
- **Response**:
  ```json
  [
    {
      "cid": 1,
      "cname": "Electronics"
    },
    {
      "cid": 2,
      "cname": "clothes"
    }
  ]
  ```

#### **3. Get Category by ID**
- **Method**: GET
- **Endpoint**: /api/categories/1
- **Response**:
  ```json
  {
    "cid": 1,
    "cname": "Electronics"
  }
  ```

#### **4. Update Category**
- **Method**: PUT
- **Endpoint**: /api/categories/1
- **Body (Raw JSON)**:
  ```json
  {
    "cname": "Updated Electronics"
  }
  ```
- **Response**:
  ```json
  {
    "cid": 1,
    "cname": "Updated Electronics"
  }
  ```

#### **5. Delete Category**
- **Method**: DELETE
- **Endpoint**: /api/categories/1
- **Response**:
  ```
  Category with ID {id} deleted successfully.
  ```

---

### **Product Endpoints**

#### **1. Create Product**
- **Method**: POST
- **Endpoint**: /api/products
- **Body (Raw JSON)**:
  ```json
  {
    "pname": "TV",
    "price": 50000.0,
    "c": {
       "cid" : 1
  }
  }
  ```
- **Response**:
  ```json
  {
    "pid": 1,
    "pname": "TV",
    "price": 50000.0,
    "c": {
      "cid": 1,
      "cname": "Electronics"
    }
  }
  ```

#### **2. Get All Products**
- **Method**: GET
- **Endpoint**: /api/products
- **Response**:
  ```json
  [
    {
      "pid": 1,
      "pname": "TV",
      "price": 50000.0,
      "c": {
        "cid": 1,
        "cname": "Electronics"
      }
    }
  ]
  ```

#### **3. Get Product by ID**
- **Method**: GET
- **Endpoint**: /api/products/1
- **Response**:
  ```json
  {
    "pid": 1,
    "pname": "TV",
    "price": 50000.0,
    "c": {
      "id": 1,
      "cname": "Electronics"
    }
  }
  ```

#### **4. Update Product**
- **Method**: PUT
- **Endpoint**: /api/products/{id}
- **Body (Raw JSON)**:
  ```json
  {
    "pname": "Updated TV",
    "price": 45000.0,
     "c":{
    "cid": 1
  }
  }
  ```
- **Response**:
  ```json
  {
    "pid": 1,
    "pname": "Updated TV",
    "price": 45000.0,
    "c": {
      "cid": 1,
      "cname": "Electronics"
    }
  }
  ```

#### **5. Delete Product**
- **Method**: DELETE
- **Endpoint**: /api/products/1
- **Response**:
  ```
  Product with ID {id} deleted successfully.
  ```



## Working Mechanism
1. **Controllers** handle incoming HTTP requests and delegate logic to the service layer.
2. **Service Layer** performs business logic and interacts with repositories.
3. **Repositories** communicate with the database to perform CRUD operations.
4. **Models** define the structure of database entities and relationships.

## Tools Used 
1. **IDE**  : Eclipse 2023
2. **DataBase** : MySql Workbench
3. **Dependency Management** : Maven
4. **Build Tools** : Spring Boot DevTools
5. **API Testing** : Postman





