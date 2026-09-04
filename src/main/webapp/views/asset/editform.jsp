<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <title>Sửa sản phẩm</title>
</head>
<body class="bg-light">

<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-12 col-md-8 col-lg-6">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h4 class="card-title mb-4">Sửa sản phẩm</h4>

                    <form action="update" method="post">
                        <input type="hidden" name="id" value="${product.id}" />

                        <div class="mb-3">
                            <label class="form-label">Tên sản phẩm</label>
                            <input type="text" name="name" class="form-control" value="${product.name}" required />
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Danh mục</label>
                            <select name="category" class="form-select" required>
                                <option value="" disabled>Chọn danh mục</option>
                                <c:if test="${not empty categories}">
                                    <c:forEach var="cat" items="${categories}">
                                        <option value="${cat.cateID}" ${cat.cateID == product.category ? 'selected' : ''}>${cat.cateName}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Giá</label>
                            <input type="number" name="price" class="form-control" min="0" value="${product.price}" required />
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Ảnh (URL)</label>
                            <input type="text" name="image" class="form-control" value="${product.image}" placeholder="https://..." />
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Mô tả</label>
                            <textarea name="description" class="form-control" rows="4">${product.description}</textarea>
                        </div>

                        <div class="d-flex justify-content-between">
                            <a href="/first-production/manager" class="btn btn-secondary">Hủy</a>
                            <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>