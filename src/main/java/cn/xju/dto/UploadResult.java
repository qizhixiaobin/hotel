package cn.xju.dto;

import lombok.Data;

@Data
public class UploadResult {
    private String link;

    public UploadResult(String link){
        this.link = link;
    }
}
