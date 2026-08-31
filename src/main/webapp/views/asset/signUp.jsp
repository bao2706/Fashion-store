<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <title>Sign Up</title>
</head>
<body>
    <section class="vh-100" style="background-color: #a9d9b4;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card shadow-2-strong" style="border-radius: 1rem;">
          <div class="card-body p-5">

            <h3 class="text-center mb-4">Create an account</h3>
            <div class ="text-danger mb-3 text-center">
              <c:if test="${not empty error}">
                ${error}
              </c:if>
              <c:if test="${not empty message}">
                <div class="text-success">${message}</div>
              </c:if>
            </div>

            <form action="signup" method="post">
              <div class="mb-3">
                <label for="user" class="form-label">Full name</label>
                <input name="user" type="text" id="fullName" class="form-control" required />
              </div>
              <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input name="password" type="password" id="password" class="form-control" required minlength="6" />
              </div>

              <div class="mb-3">
                <label for="confirmPassword" class="form-label">Confirm password</label>
                <input name="confirmPassword" type="password" id="confirmPassword" class="form-control" required minlength="6" />
              </div>

              <div class="d-grid">
                <button class="btn btn-primary btn-lg" type="submit">Sign Up</button>
              </div>
            </form>

            <hr class="my-4">
            <p class="text-center mb-0">Already have an account? <a href="login">Login</a></p>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>