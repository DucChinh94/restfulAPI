package controller;

import entity.Student;
import service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

@Path("api")
public class StudentAPI {
    StudentService studentService = new StudentService();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudent() {
        return studentService.getListStudent();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(@PathParam("id") int id) {
        return studentService.findID(id);
    }

    @GET
    @Path("/name/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByName( @PathParam("value")  String value) {
        return studentService.searchListStudentByString("name",value);
    }

    @GET
    @Path("/gender/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByGender(@PathParam("value")  String value) {
        return studentService.searchListStudentByString("gender",value);
    }

    @GET
    @Path("/major/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByMajor(@PathParam("value")  String value) {
        return studentService.searchListStudentByString("major",value);
    }

    @GET
    @Path("/className/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByClassName(@PathParam("value")  String value) {
        return studentService.searchListStudentByString("className",value);
    }
    @GET
    @Path("/averageMark/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> searchStudentByAverageMark(@PathParam("value")  Float value) {
        return studentService.searchListStudentByNumber("averageMark",value);
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addNewStudent(Student student) {
        return studentService.insert(student) ? "Th??m m???i th??nh c??ng" : "Th??m m???i th???t b???i";
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String removeStudent(@PathParam("id") int id) {
        return studentService.removeStudent(id) ? "X??a th??nh c??ng" : "X??a th???t b???i";
    }

}
