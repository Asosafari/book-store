package com.spring.book_store.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Author: ASOU SAFARI
 * Date:5/23/24
 * Time:9:01 PM
 */

@Setter
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Publisher {

    @Id
    @UuidGenerator
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)",updatable = false,nullable = false)
    private UUID id;

    @NotBlank
    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    private String label;

    @NotBlank
    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    private String zipCode;

    @Email(regexp = ".+[@].+[\\.].+")
    String email;

    @Version
    private Integer version;

    @Builder.Default
    @OneToMany(mappedBy = "publisher")
    private Set<Book> books = new HashSet<>();

    @Builder.Default
    @ManyToMany(mappedBy = "publishers")
    private Set<Author> authors = new HashSet<>();

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;


}
