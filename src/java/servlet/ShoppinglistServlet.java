    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package servlet;

    import java.io.IOException;
    import java.io.PrintWriter;
    import static java.nio.file.Files.delete;
    import java.util.ArrayList;
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.servlet.http.HttpSession;

    /**
     *
     * @author 794974
     */
    public class ShoppinglistServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            HttpSession session = request.getSession();
            String logout = request.getParameter("logout");
            if(logout!=null){
                session.invalidate();
                request.setAttribute("success", true);
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
            }else{        
          request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
            }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            HttpSession session = request.getSession();

            String username = request.getParameter("username");
            String goods = request.getParameter("item");
             String item_to_delete =  request.getParameter("added_item");
            ArrayList<String> items = (ArrayList<String>) request.getSession().getAttribute("items");
            
               if(request.getParameter("register") != null){

                    session.setAttribute("username", username);

                    getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);

            } else if(request.getParameter("add")!=null){

                if(items == null){
                    items = new ArrayList<>();

                items.add(goods);
                request.getSession().setAttribute("items", items);
                request.getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
                }
                else{
                    if(goods == null || goods.equals("")){
                        request.setAttribute("empty_goods", true);
                        request.getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
                    }else{

                items.add(goods);
                request.getSession().getAttribute("items");
                request.getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
                        } 
                }

            }else if(request.getParameter("delete")!= null && item_to_delete!= null){ 
                
                             int index = items.indexOf(item_to_delete);
                            
                        System.out.println( index +"  "+ "inside else if");
                            items.remove(index);
                            request.getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);

            }else{
                request.setAttribute("deleteError", true);
                request.getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
            }

            }

        } 
