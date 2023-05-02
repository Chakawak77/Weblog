package com.kurd.common;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Paging<T> {
    private Integer allPage;
    private Integer currentPage;
    private List<T> data;

}
