package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DailyReservationData;
import model.MeetingRoom;
import model.ReservationData;
import model.User;

@WebServlet("/Reservation")
public class Reservation extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReservationData reservationData = new ReservationData();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            String date = request.getParameter("date");
            String roomId = request.getParameter("roomId");
            String action = request.getParameter("action");

            DailyReservationData dailyReservationData = reservationData.getDailyReservationData(date);
            MeetingRoom room = dailyReservationData.getRooms().get(roomId);

            if (room != null) {
                if ("reserve".equals(action) && !room.isReserved()) {
                    room.setReserved(true);
                    room.setReserverName(user.getUsername());
                } else if ("cancel".equals(action) && room.isReserved() && room.getReserverName().equals(user.getUsername())) {
                    room.setReserved(false);
                    room.setReserverName("");
                }
            }
        }

        response.sendRedirect("MeetingRoomReservedMain?date=" + request.getParameter("date"));
    }
}
