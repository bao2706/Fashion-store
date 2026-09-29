<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thử validate</title>
</head>
<body>
    <h2>Thử kiểm tra số lượng</h2>

    <form action="${pageContext.request.contextPath}/validate-demo" method="post">
        <input type="text" name="quantity" placeholder="Nhập số lượng">
        <button type="submit">Kiểm tra</button>
    </form>

    <p style="color: red;">${error}</p>
    <p style="color: green;">${success}</p>
</body>
</html>