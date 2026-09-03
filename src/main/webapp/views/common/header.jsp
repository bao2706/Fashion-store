<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">

                <a class="navbar-brand" href="/first-production">
                    Shop Quần Áo
                </a>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">

                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">

                        <li class="nav-item">
                            <a class="nav-link active" href="/first-production">
                                Home
                            </a>
                        </li>
                        <c:if test="${sessionScope.user == null}">
                            <li class="nav-item">
                                <a class="nav-link active" href="/first-production/login">
                                    Login
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.user != null}">
                            <li class="nav-item">
                                <a class="nav-link active" href="/first-production/logout">
                                    Log out
                                </a>
                            </li>
                        </c:if>
                        </li>
                        <c:if test="${sessionScope.user != null && sessionScope.user.issell == 1 }">
                            <li class="nav-item">
                                <a class="nav-link" href="/first-production/manager">
                                    Manager Product
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.user != null && sessionScope.user.isAdmin == 1 }">
                            <li class="nav-item">
                                <a class="nav-link" href="#!">
                                    Manager Accout
                                </a>
                            </li>
                        </c:if>
                    
                        <li class="nav-item">
                            <p class="nav-link">
                                Hello ${sessionScope.user != null ? sessionScope.user.username : "Guest"}
                            </p>
                        </li>
                    </ul>

                    <!-- Cart -->
                    <form class="d-flex p-3">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi bi-cart-fill me-1"></i>
                            Cart

                            <span class="badge bg-dark text-white ms-1 rounded-pill">
                                0
                            </span>
                        </button>
                    </form>
                    <form class="d-flex g-5" action="search" method="post">
                        <input class="form-control me-2" type="text" placeholder="Search" name="txt"
                            value="${txtSearch}">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi bi-search"></i>
                        </button>
                    </form>

                </div>
            </div>
        </nav>
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                0
                </span>
                </button>
                </form>

            </div>
            </div>
        </header>
        </nav>
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">

                <div class="text-center text-white">

                    <h1 class="display-4 fw-bolder">
                        Welcome to Shop
                    </h1>

                    <p class="lead fw-normal text-white-50 mb-0">
                        ✨◕ω◕
                    </p>
                </div>
            </div>
        </header>