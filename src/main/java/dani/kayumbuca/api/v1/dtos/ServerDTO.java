package dani.kayumbuca.api.v1.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ServerDTO(@NotBlank  String name, @NotNull  String public_ip, @Nullable String private_ip ) {
}
