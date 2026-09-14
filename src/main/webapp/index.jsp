<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">

            <meta name="description" content="">
            <meta name="author" content="">

            <title>Shop Homepage</title>

            <!-- Favicon -->
            <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/1/assets/favicon.ico">

            <!-- Bootstrap CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

            <!-- Bootstrap Icons -->
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

            <!-- Custom CSS -->
            <link href="${pageContext.request.contextPath}/1/css/styles.css" rel="stylesheet">
        </head>

        <body>
            <jsp:include page="/views/common/header.jsp"></jsp:include>

            <!-- ==================== Navigation ==================== -->



            <!-- ==================== Header ==================== -->



            <!-- ==================== Category ==================== -->
            <div class="container mt-4">

                <div class="row g-3">

                    <c:forEach items="${listCategory}" var="o">
                        <div class="col-6 col-md-3">
                            <a href="${pageContext.request.contextPath}/category?cateID=${o.cateID}"
                                class="btn btn-outline-dark w-100 py-3 ${tag == o.cateID ? " active":""}">
                                ${o.cateName}
                            </a>
                        </div>
                    </c:forEach>
                </div>

            </div>
            <!-- ==================== Product Section ==================== -->
            <section class="py-5">

                <div class="container px-4 px-lg-5 mt-5">

                    <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                        <c:if test="${empty listProduct}">
                            <h3 class="text-center w-100 mt-5">Không tìm thấy sản phẩm nào!</h3>
                        </c:if>

                        <!-- Product Loop -->
                        <c:forEach items="${listProduct}" var="o">

                            <div class="col mb-5">

                                <div class="card h-100">

                                    <!-- Product Image -->
                                    <img class="card-img-top"
                                        src="${pageContext.request.contextPath}/image/${o.image != null ? o.image : 'https://via.placeholder.com/450x300?text=No+Image'}"
                                        alt="${pageContext.request.contextPath}/image/${o.image != null ? o.image : 'https://via.placeholder.com/450x300?text=No+Image'}">

                                    <!-- Product Details -->
                                    <div class="card-body p-4">

                                        <div class="text-center">

                                            <!-- Product Name -->
                                            <h5 class="fw-bolder">
                                                ${o.name}
                                            </h5>

                                            <!-- Product Price -->
                                            <span>
                                                ${o.price} $
                                            </span>

                                        </div>

                                    </div>

                                    <!-- Product Actions -->
                                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">

                                        <div class="text-center">

                                            <a class="btn btn-outline-dark mt-auto" href="${pageContext.request.contextPath}/detail?id=${o.id}">
                                                View options
                                            </a>

                                        </div>

                                    </div>

                                </div>

                            </div>

                        </c:forEach>

                    </div>

                </div>

            </section>


            <!-- ==================== Footer ==================== -->
            <jsp:include page="/views/common/footer.jsp"></jsp:include>

            <!-- Bootstrap JS -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

            <!-- Custom JS -->
            <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
        </body>

        </html>