package com.cg.spring.data.jpa.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable // - Tells hibernate that we want these fields part of the same table as the students while having this data in
// a separate class like it should be, since this is not student data.
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// - @AttributeOverrides is useful when you have already created column names before separating the entities up into
// separate classes. In the student class we could have had this guardian entity mapped as just guardianName, guardianEmail, and
// guardianMobile. If we were to then move the guardian attributes to its own class, those names don't make sense anymore, which
// is why here they are simply name, email, and phone. However the database columns could have already been made with the previous
// names, meaning they don't line up anymore with this restructured class. To get things matching up again when persisting to the
// database, we need to use these override attributes.
/*@AttributeOverrides(
        {
                @AttributeOverride(
                        name="name",
                        column = @Column(name="some_already_created_database_column_name")
                ),
                @AttributeOverride(
                        name="email",
                        column = @Column(name="some_already_created_database_column_name")
                ),
                @AttributeOverride(
                        name="mobile",
                        column = @Column(name="some_already_created_database_column_name")
                )
        }
)*/
public class Guardian {
    @Column(name="guardian_name")
    private String name;
    @Column(name="guardian_email")
    private String email;
    @Column(name="guardian_mobile")
    private String mobile;
}
