package DAOs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
    public class ShowProductsServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            Products productsDao = DaoFactory.getProductsDao();

            List<Product> products = productsDao.all();

            request.setAttribute("products", products);
            request.getRequestDispatcher("/products/index.jsp").forward(request, response);
        }

    }
