<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body class="bg-light">

<jsp:include page="/views/common/header.jsp" />

<div class="container py-5">
    <h2 class="mb-4">Giỏ hàng của bạn</h2>

    <c:if test="${not empty cart}">
        <div class="table-responsive mb-3">
            <table class="table table-bordered align-middle">
                <thead class="table-light">
                <tr>
                    <th>Ảnh</th>
                    <th>Tên</th>
                    <th>Giá</th>
                    <th style="width:170px">Số lượng</th>
                    <th>Thành tiền</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:set var="total" value="0" />
                <c:forEach var="item" items="${cart}">
                    <tr>
                        <td style="width:100px">
                            <img src="${item.image}" alt="${item.name}" class="img-fluid rounded" style="max-width:80px; height:80px; object-fit:cover;"/>
                        </td>
                        <td>${item.name}</td>
                        <td class="fw-bold">${item.price}đ</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/cart/update" method="post" class="d-flex align-items-center">
                                <input type="hidden" name="id" value="${item.id}" />
                                <input type="number" name="quantity" value="${item.quantity}" min="1" class="form-control form-control-sm" style="width:80px;" />
                                <button type="submit" class="btn btn-sm btn-outline-primary ms-2">Cập nhật</button>
                            </form>
                        </td>
                        <td class="fw-bold text-danger">${item.price * item.quantity}đ</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/cart/remove" method="post">
                                <input type="hidden" name="id" value="${item.id}" />
                                <button type="submit" class="btn btn-sm btn-danger">Xóa</button>
                            </form>
                        </td>
                    </tr>
                    <c:set var="total" value="${total + (item.price * item.quantity)}" />
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="d-flex justify-content-between align-items-center">
            <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Tiếp tục mua sắm</a>
            <div>
                <span class="me-3">Tổng:</span>
                <span class="fs-5 fw-bold text-danger">${total}đ</span>
                <a href="${pageContext.request.contextPath}/checkout" class="btn btn-success ms-3">Thanh toán</a>
            </div>
        </div>

    </c:if>

    <c:if test="${empty cart}">
        <div class="alert alert-info">Giỏ hàng trống. <a href="${pageContext.request.contextPath}/home">Tiếp tục mua sắm</a></div>
    </c:if>

</div>

<jsp:include page="/views/common/footer.jsp" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
