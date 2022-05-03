package ru.iteco.account.controllerAndRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.iteco.account.exceptionsAndValidations.Create;
import ru.iteco.account.exceptionsAndValidations.Update;
import ru.iteco.account.modelAndEntity.BankBookDto;
import ru.iteco.account.serviceAndMapper.BankBookService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("/rest/bank-book")
public class BankBookController {

    private final BankBookService bankBookService;

    public BankBookController(BankBookService bankBookService) {
        this.bankBookService = bankBookService;
    }

    @GetMapping({"/{id}", "/"})
    public ResponseEntity<BankBookDto> getBankBookById(@Min(value = 0L, message = "Больше 0!") @PathVariable Integer id) {
        return ResponseEntity.ok(bankBookService.findById(id));
    }

    @GetMapping("/by-user-id")
    public ResponseEntity<List<BankBookDto>> getBankBookByUserId(@CookieValue Integer userId, @RequestHeader Map<String, String> headers) {
        log.info("Call with headers: {}", headers);
        return ResponseEntity.ok(bankBookService.findByUserId(userId));
    }

    @Validated(Create.class)
    @PostMapping
    public ResponseEntity<BankBookDto> createBankBook(@Valid @RequestBody BankBookDto bankBookDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bankBookService.create(bankBookDto));
    }

    @Validated(Update.class)
    @PutMapping
    public BankBookDto updateBankBook(@Valid @RequestBody BankBookDto bankBookDto) {
        return bankBookService.update(bankBookDto);
    }

    @DeleteMapping({"/{id}", "/"})
    public void deleteBankBook(@PathVariable Integer id) {
        bankBookService.delete(id);
    }

    @DeleteMapping({"/by-user-id/{id}", "/by-user-id/"})
    public void deleteBankBookByUserId(@PathVariable Integer id) {
        bankBookService.deleteByUserId(id);
    }

}
