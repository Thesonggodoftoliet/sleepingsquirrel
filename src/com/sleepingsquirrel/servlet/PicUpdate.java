package com.sleepingsquirrel.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;


@WebServlet("/PicUpdate")
public class PicUpdate extends HttpServlet {

    public PicUpdate() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[-------------------------------------------------------]");
        String filepath=request.getServletContext().getRealPath("/")+"upload\\";
        File file = new File(filepath);
        if(!file.exists()) {
            file.mkdir();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> items= upload.parseRequest(request);
            for(FileItem item: items) {
                System.out.println(filepath+item.getName());
                if(!item.isFormField()) {
                    item.write(new File(filepath+item.getName()));
                }
                if(item.isFormField()){
                    System.out.println(item.getString());
                    System.out.println(item.getFieldName());
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}