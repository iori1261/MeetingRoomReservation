<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>会議室予約</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .meeting-room {
            display: inline-block;
            width: 22%;
            margin: 1%;
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
            box-sizing: border-box;
        }
        .meeting-room img {
            width: 100%;
            height: auto;
        }
        .meeting-room p {
            margin: 5px 0;
        }
        .meeting-room table {
            width: 100%;
            border-collapse: collapse;
        }
        .meeting-room table, .meeting-room th, .meeting-room td {
            border: 1px solid #ccc;
        }
        .meeting-room th, .meeting-room td {
            padding: 5px;
            text-align: center;
        }
        .meeting-room .btn {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            text-align: center;
            border: none;
            cursor: pointer;
        }
        .meeting-room .btn:disabled {
            background-color: #ccc;
        }
    </style>
</head>
<body>
    <h1>会議室予約システム</h1>
    <form method="get" action="MeetingRoomReservedMain">
        <input type="date" name="date" value="${date}">
        <input type="submit" value="表示">
    </form>
    <div>
        <c:forEach var="room" items="${reservationData.rooms}">
            <div class="meeting-room">
                <img src="${pageContext.request.contextPath}/image/${room.value.imagePath}" alt="${room.value.roomName}">
                <p>${room.value.roomName}</p>
                <p>利用可能人数: ${room.value.capacity}</p>
                <table>
                    <tr>
                        <th>予約状況</th>
                        <th>予約者</th>
                    </tr>
                    <tr>
                        <td><c:choose>
                            <c:when test="${room.value.isReserved}">済</c:when>
                            <c:otherwise>未</c:otherwise>
                        </c:choose></td>
                        <td><c:choose>
                            <c:when test="${room.value.isReserved}">${room.value.reserverName}</c:when>
                            <c:otherwise>-</c:otherwise>
                        </c:choose></td>
                    </tr>
                </table>
                <c:if test="${not room.value.isReserved}">
                    <form action="${pageContext.request.contextPath}/Reservation" method="post">
                        <input type="hidden" name="roomId" value="${room.value.roomId}">
                        <input type="hidden" name="date" value="${date}">
                        <input type="hidden" name="action" value="reserve">
                        <input type="submit" class="btn" value="予約">
                    </form>
                </c:if>
                <c:if test="${room.value.isReserved && room.value.reserverName == sessionScope.user.username}">
                    <form action="${pageContext.request.contextPath}/Reservation" method="post">
                        <input type="hidden" name="roomId" value="${room.value.roomId}">
                        <input type="hidden" name="date" value="${date}">
                        <input type="hidden" name="action" value="cancel">
                        <input type="submit" class="btn" value="キャンセル">
                    </form>
                </c:if>
            </div>
        </c:forEach>
    </div>
</body>
</html>
