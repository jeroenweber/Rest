package assignments.restservice.beans;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HouseResponse {
    private int status = 200;
    private List<House> result;
    private String createdSource;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<House> getResult() {
        return result;
    }

    public void setResult(List<House> result) {
        this.result = result;
    }

    public String getCreatedSource() {
        return createdSource;
    }

    public void setCreatedSource(String createdSource) {
        this.createdSource = createdSource;
    }
}
