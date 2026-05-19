package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public final class Contact {
    @Builder.Default
    private final String title = "";
    @Builder.Default
    private final String firstName = "";
    @Builder.Default
    private final String lastName = "test";
    @Builder.Default
    private final String phone = "";
    @Builder.Default
    private final String mobile = "";
    @Builder.Default
    private final String job = "";
    @Builder.Default
    private final String department = "";
    @Builder.Default
    private final String fax = "";
    @Builder.Default
    private final String numberEmail = "";
    @Builder.Default
    private final String address = "";
    @Builder.Default
    private final String city = "";
    @Builder.Default
    private final String region = "";
    @Builder.Default
    private final String postalCode = "";
    @Builder.Default
    private final String country = "";
    @Builder.Default
    private final String description = "";
    @Builder.Default
    private final String leadSource = "";
}
