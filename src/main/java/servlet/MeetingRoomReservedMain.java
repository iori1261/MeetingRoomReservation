package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ReservationData;
import model.User;

@WebServlet("/MeetingRoomReservedMain")
public class MeetingRoomReservedMain extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReservationData reservationData = new ReservationData();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.html");
        } else {
            String date = request.getParameter("date");
            if (date == null) {
                LocalDate today = LocalDate.now();
                date = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }

            request.setAttribute("reservationData", reservationData.getDailyReservationData(date));
            request.setAttribute("date", date);
            request.getRequestDispatcher("/WEB-INF/jsp/MeetingRoomReservation.jsp").forward(request, response);
        }
    }
}
