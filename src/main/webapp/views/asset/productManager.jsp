<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>

        <!DOCTYPE html>

        <html lang="vi">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">

            <title>Quản lý sản phẩm</title>

            <!-- Bootstrap -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

            <!-- Bootstrap Icons -->
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        </head>

        <body class="bg-light">

            <!-- Header -->
            <jsp:include page="/views/common/header.jsp" />

            <div class="container py-5">

                <!-- HEADER -->
                <div class="card shadow-sm border-0 mb-4">
                    <div class="card-body">

                        <div class="d-flex flex-column flex-md-row
                            justify-content-between
                            align-items-md-center gap-3">

                            <div>
                                <h2 class="mb-1 fw-bold">
                                    Quản lý sản phẩm
                                </h2>

                                <p class="text-muted mb-0">
                                    Danh sách các món hàng đang bán
                                </p>
                            </div>

                            <!-- BUTTON THÊM SẢN PHẨM -->
                            <button class="btn btn-primary" type="button" id="btnAddProduct" data-bs-toggle="modal"
                                data-bs-target="#productModal">

                                <i class="bi bi-plus-circle me-1"></i>

                                Thêm sản phẩm

                            </button>

                        </div>

                    </div>
                </div>

                <!-- PRODUCT TABLE -->
                <div class="card shadow-sm border-0">

                    <div class="card-body p-0">

                        <div class="table-responsive">

                            <table class="table table-striped table-bordered align-middle mb-0">

                                <thead class="table-light">

                                    <tr>
                                        <th>Ảnh</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Giá</th>
                                        <th class="text-center">Thao tác</th>
                                    </tr>

                                </thead>



                                <tbody id="productTableBody">

                                    <c:if test="${not empty product}">

                                        <c:forEach var="o" items="${product}">

                                            <tr data-id="${o.id}" data-name="${o.name}" data-price="${o.price}"
                                                data-image="${pageContext.request.contextPath}/image/${o.image}"
                                                data-description="${o.description}">

                                                <td>

                                                    <img class="img-fluid rounded"
                                                        src="${pageContext.request.contextPath}/image/${o.image}"
                                                        alt="${o.name}"
                                                        style="max-width:80px;height:80px;object-fit:cover;">

                                                </td>

                                                <td>${o.name}</td>
                                                <td class="fw-bold text-danger">${o.price}đ</td>
                                                <td class="text-center">
                                                    <div class="d-flex justify-content-center gap-2">
                                                        <form action="${pageContext.request.contextPath}/manager/edit" method="get">
                                                            <input type="hidden" name="id" value="${o.id}">
                                                            <button type="submit">Edit</button>
                                                        </form>
                                                        <form action="${pageContext.request.contextPath}/manager/delete" method="post">
                                                            <input type="hidden" name="id" value="${o.id}">
                                                            <button type="submit">Xóa</button>
                                                        </form>

                                                    </div>
                                                </td>

                                            </tr>

                                        </c:forEach>

                                    </c:if>

                                    <c:if test="${empty product}">

                                        <tr>

                                            <td colspan="7" class="text-center text-muted py-4">Chưa có sản phẩm</td>

                                        </tr>

                                    </c:if>

                                </tbody>

                            </table>

                        </div>

                    </div>

                </div>

            </div>


            <!-- MODAL THÊM / SỬA SẢN PHẨM -->
            <div class="modal fade" id="productModal" tabindex="-1" aria-labelledby="productModalLabel"
                aria-hidden="true">

                <div class="modal-dialog modal-dialog-centered">

                    <div class="modal-content">

                        <form id="productForm" action="${pageContext.request.contextPath}/manager/add" method="post">

                            <!-- HEADER -->
                            <div class="modal-header">

                                <h5 class="modal-title" id="productModalLabel">

                                    Thêm sản phẩm

                                </h5>

                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                                </button>

                            </div>


                            <!-- BODY -->
                            <div class="modal-body">

                                <input type="hidden" id="productId" name="id">


                                <div class="row g-3">

                                    <!-- TÊN -->
                                    <div class="col-md-6">

                                        <label for="productName" class="form-label">

                                            Tên sản phẩm

                                        </label>

                                        <input type="text" class="form-control" id="productName" name="name" required>

                                    </div>


                                    <!-- DANH MỤC -->
                                    <div class="col-md-6">

                                        <label for="productCategory" class="form-label">

                                            Danh mục

                                        </label>

                                        <select class="form-select" id="productCategory" name="category" required>

                                            <option value="" disabled selected>Chọn danh mục</option>

                                            <c:if test="${not empty categories}">
                                                <c:forEach var="cat" items="${categories}">
                                                    <option value="${cat.cateID}">${cat.cateName}</option>
                                                </c:forEach>
                                            </c:if>

                                        </select>

                                    </div>


                                    <!-- GIÁ -->
                                    <div class="col-md-4">

                                        <label for="productPrice" class="form-label">

                                            Giá

                                        </label>

                                        <input type="number" class="form-control" id="productPrice" name="price" min="0"
                                            required>

                                    </div>

                                    <!-- ẢNH -->
                                    <div class="col-md-4">

                                        <label for="productImage" class="form-label">

                                            Ảnh

                                        </label>

                                        <input type="text" class="form-control" id="productImage" name="image"
                                            placeholder="https://...">

                                    </div>


                                    <!-- MÔ TẢ -->
                                    <div class="col-12">

                                        <label for="productDescription" class="form-label">

                                            Mô tả

                                        </label>

                                        <textarea class="form-control" id="productDescription" name="description"
                                            rows="3" required></textarea>

                                    </div>

                                </div>

                            </div>


                            <!-- FOOTER -->
                            <div class="modal-footer">

                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">

                                    Đóng

                                </button>

                                <button type="submit" class="btn btn-primary" id="saveProductBtn">

                                    Lưu

                                </button>

                            </div>

                        </form>

                    </div>

                </div>

            </div>


            <!-- Footer -->
            <jsp:include page="/views/common/footer.jsp" />


            <!-- Bootstrap JS -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js">
            </script>

        </body>

        </html>