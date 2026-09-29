<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Không tìm thấy trang | Fashion Store</title>
    <style>
        * { box-sizing: border-box; }

        body {
            min-height: 100vh;
            margin: 0;
            display: grid;
            place-items: center;
            background: linear-gradient(135deg, #fff6f2, #fbe5ed);
            font-family: Arial, sans-serif;
            color: #29232b;
        }

        main {
            width: min(90%, 560px);
            padding: 52px 32px;
            text-align: center;
            background: white;
            border-radius: 24px;
            box-shadow: 0 20px 60px rgba(80, 35, 55, .12);
        }

        .brand { font-size: 13px; letter-spacing: 4px; font-weight: bold; }
        .number { margin: 25px 0 8px; font-size: clamp(90px, 20vw, 150px);
                  line-height: 1; font-weight: 800; color: #df7597; }
        h1 { font-size: 26px; }
        p { color: #756d75; line-height: 1.6; }

        a {
            display: inline-block;
            margin-top: 20px;
            padding: 13px 26px;
            border-radius: 30px;
            background: #29232b;
            color: white;
            text-decoration: none;
        }
        a:hover { background: #df7597; }
    </style>
</head>
<body>
    <main>
        <div class="brand">FASHION STORE</div>
        <div class="number">404</div>
        <h1>Trang này đã đi lạc</h1>
        <p>Đường dẫn có thể đã thay đổi hoặc trang bạn tìm không tồn tại.</p>
        <a href="${pageContext.request.contextPath}/home">Về trang chủ</a>
    </main>
</body>
</html>