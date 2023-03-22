package com.cg.eazyschool.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Holiday {
    private final String day;
    private final String reason;
    private final Type type;
    public enum Type{
        FESTIVAL, FEDERAL
    }
}
