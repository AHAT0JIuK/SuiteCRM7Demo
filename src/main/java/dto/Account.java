package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public final class Account {
    @Builder.Default
    private final String name = "test";
    @Builder.Default
    private final String phone = "";
    @Builder.Default
    private final String fax = "";
    @Builder.Default
    private final String website = "";
    @Builder.Default
    private final String billingStreet = "";
    @Builder.Default
    private final String shippingStreet = "";
    @Builder.Default
    private final String type = "";
    @Builder.Default
    private final String industry = "";
    @Builder.Default
    private final String numberEmail = "";
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
    private final String annualRevenue = "";
    @Builder.Default
    private final String employees = "";
}
