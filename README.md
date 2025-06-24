# Advanced-Math-Java

## 📌 1️⃣ Introduction

Mathematics forms the backbone of almost every scientific and technological breakthrough. From computer graphics to machine learning, from cryptography to control systems — math is everywhere. This project is a humble attempt to understand the **behind-the-scenes** working of many important mathematical operations that are frequently used across diverse fields. Rather than relying solely on libraries, **Advanced-Math-Java** explores how these algorithms work under the hood, written from scratch in Java.

---

## 📌 2️⃣ File Structure

<pre>
Advanced-Math-Java/
├── Calculus/
│   ├── MVC.java        # Multivariable Calculus utilities
│   └── SVC.java        # Single Variable Calculus utilities
│
├── Matrix/
│   ├── Decomposition.java  # Matrix decomposition algorithms
│   ├── Operations.java     # Matrix operations
│   └── Solve.java          # Linear equation solvers (Ax = B)
│
└── Vectors/
└── Operations.java     # Vector operations
</pre>


### 📂 Calculus

#### `MVC.java` *(Multivariable Calculus)*
- `grad()` — Compute gradient of multivariable functions.
- `d2f_dx1dx2()` — Compute second-order partial derivatives.
- `heassian()` — Compute Hessian matrix.

#### `SVC.java` *(Single Variable Calculus)*
- `RK4()` — TODO: Runge-Kutta 4th order.
- `RK5()` — Runge-Kutta 5th order.
- `ode45()` — Adaptive Runge-Kutta (4th & 5th).
- `differentiate()` — Differentiate a function (with order support).
- `df()` — Shortcut for differentiation.
- `integrate()` — Numerical integration.
- `factorial()` — Factorial of a number.
- `taylor()` — Compute Taylor series coefficients up to *n*-th order.
- `mcLurian()` — Compute McLaurin series up to *n*-th order.

---

### 📂 Matrix

#### `Decomposition.java`
- `svd()` — Singular Value Decomposition.
- `polar()` — Polar decomposition.
- `qr()` — QR decomposition.
- `lu()` — LU decomposition.

#### `Operations.java`
- `addition()`, `subtract()` — Matrix arithmetic.
- `aug()`, `augRow()`, `augCol()` — Matrix augmentation utilities.
- `copy()` — Deep copy of matrices.
- `det()` — Determinant of matrix.
- `diag()`, `diag_prod()` — Diagonal matrix handling and product.
- `GSO()` — Gram-Schmidt Orthogonalization.
- `eig()` — Eigenvalues and eigenvectors.
- `inv()` — Inverse of a matrix.
- `leftInv()`, `rightInv()` — Left and right inverses.
- `pinv()` — Pseudo-inverse.
- `eye()` — Generate identity matrix.
- `zeros()` — Generate zero matrix.
- `isConverged()` — Check for convergence in iterative processes.
- `isSquare()` — Check if matrix is square.
- `printMat()` — Utility to print matrices.
- `rref()` — Row Reduced Echelon Form.

#### `Solve.java`
- `solve()` — Solve linear systems *Ax = B*.

---

### 📂 Vectors

#### `Operations.java`
- `add()`, `subtract()` — Vector arithmetic.
- `dot()` — Dot product.
- `norm()` — Compute vector norm.
- `normalise()` — Normalize vector.
- `scale()` — Scalar multiplication.
- `printVec()` — Utility to print vectors.
- `zeros()` — Generate zero vector.

---

## 📌 3️⃣ Usage & Philosophy

This project isn’t aimed at enterprise-level work environments or production-ready systems. It’s a **fun exploration** of core mathematical algorithms on a *basic, educational scale*. Whether you’re a student, hobbyist, or curious programmer, feel free to **fork**, **tweak**, and **experiment** with the code.

This was built to learn — and hopefully, to help others learn as well.

---
