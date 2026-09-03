<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Product Detail">
    <meta name="author" content="">

    <title>${product.name} - Shop Quần Áo</title>

    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="1/assets/favicon.ico">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <!-- Custom CSS -->
    <link href="1/css/styles.css" rel="stylesheet">
</head>

<body>

    <!-- ==================== Navigation ==================== -->
     <jsp:include page="/views/common/header.jsp"></jsp:include>
    <!-- ==================== Product Detail Section ==================== -->
    <section class="py-5">
        <div class="container px-4 px-lg-5 my-5">
            <div class="row gx-4 gx-lg-5 align-items-center">
                
                <!-- Product Image -->
                <div class="col-md-6">
                    <!-- Giả sử biến ${product.image} chứa URL ảnh, nếu không có thể dùng ảnh mặc định -->
                    <img class="card-img-top mb-5 mb-md-0 rounded" 
                         src="${pageContext.request.contextPath}/image/${product.image != null ? product.image : 'https://via.placeholder.com/450x300?text=No+Image'}"
" 
                         alt="${pageContext.request.contextPath}/image/${product.image != null ? product.image : 'https://via.placeholder.com/450x300?text=No+Image'}" />
                </div>
                
                <!-- Product Info -->
                <div class="col-md-6">
                    <div class="small mb-1">Mã sản phẩm: ${product.id}</div>
                    <h1 class="display-5 fw-bolder">${product.name}</h1>
                    
                    <div class="fs-5 mb-5">
                        <!-- Nếu có giá khuyến mãi có thể thêm thẻ <span class="text-decoration-line-through">Giá cũ</span> -->
                        <span class="fw-bold text-danger">${product.price} $</span>
                    </div>
                    
                    <p class="lead">${product.description}</p>
                    
                    <!-- Add to Cart Form -->
                    <form action="add-to-cart" method="POST">
                        <div class="d-flex">
                            <input type="hidden" name="productId" value="${product  .id}">
                            <input class="form-control text-center me-3" id="inputQuantity" name="quantity" type="number" value="1" min="1" style="max-width: 4rem" />
                            <button class="btn btn-outline-dark flex-shrink-0" type="submit">
                                <i class="bi-cart-fill me-1"></i>
                                Add to cart
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <!-- ==================== Related Products (Tùy chọn) ==================== -->
    <section class="py-5 bg-light">
        <div class="container px-4 px-lg-5 mt-5">
            <h2 class="fw-bolder mb-4">Sản phẩm liên quan</h2>
            <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                
                <!-- Vòng lặp các sản phẩm cùng danh mục -->
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="${pageContext.request.contextPath}/image/${product.image != null ? product.image : 'https://via.placeholder.com/450x300?text=No+Image'}" alt="${product.name}" />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <h5 class="fw-bolder">${product.name}</h5>
                                    ${product.price} $
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center">
                                    <a class="btn btn-outline-dark mt-auto" href="detail?id=${product.id}">Xem chi tiết</a>
                                </div>
                            </div>
                        </div>
                    </div>

            </div>
        </div>
    </section>

    <!-- ==================== Footer ==================== -->
  <jsp:include page="/views/common/footer.jsp"></jsp:include>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
    
    <!-- Custom JS -->
    <script src="1/js/scripts.js"></script>

</body>
</html>