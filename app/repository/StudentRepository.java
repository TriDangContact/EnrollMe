package repository;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.Transaction;
import models.Student;
import play.db.ebean.EbeanConfig;

import javax.inject.Inject;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class StudentRepository {
    private final EbeanServer ebeanServer;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public StudentRepository(EbeanConfig ebeanConfig, DatabaseExecutionContext executionContext) {
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
        this.executionContext = executionContext;
    }

    public CompletionStage<Long> insert(Student student) {
        return supplyAsync(() -> {
            student.save();
            return student.getId();
        }, executionContext);
    }

    public CompletionStage<Optional<Student>> lookup(Long id) {
        return supplyAsync(() -> Optional.ofNullable(Student.find.byId(id)), executionContext);
    }

    public CompletionStage<Optional<Long>> update(Long id, Student newStudentData) {
        return supplyAsync(() -> {
            Transaction txn = ebeanServer.beginTransaction();
            Optional<Long> studentId = Optional.empty();
            try {
                Student savedStudent = Student.find.byId(id);
                if (savedStudent != null) {
                    savedStudent.setFirstName(newStudentData.getFirstName());
                    savedStudent.setLastName(newStudentData.getLastName());
                    savedStudent.setEmail(newStudentData.getEmail());
                    savedStudent.setPhone(newStudentData.getPhone());
                    savedStudent.setPassword(newStudentData.getPassword());
                    savedStudent.setStreet(newStudentData.getStreet());
                    savedStudent.setCity(newStudentData.getCity());
                    savedStudent.setState(newStudentData.getState());
                    savedStudent.setCountry(newStudentData.getCountry());
                    savedStudent.setZip(newStudentData.getZip());
                    savedStudent.setMajor(newStudentData.getMajor());
                    savedStudent.setMinor(newStudentData.getMinor());

                    savedStudent.update();
                    txn.commit();
                    studentId = Optional.of(id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                txn.end();
            }
            return studentId;
        }, executionContext);
    }
}
