package com.paginaton.sorting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Slice;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse<T>{
    int recordCount;
    T response;
}
