package view;

import dto.LadderParameter;
import validator.InputValidator;
import dto.InputRepeatableDTO;
import validator.dto.InputValidationRequest;
import validator.type.ValidateType;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT_MESSAGE = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String NAME_DELIMITER = ",";
    private static final String INPUT_RESULTS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String VIEW_ALL_PLAYERS_MESSAGE = "all";
    private static final String INPUT_RESULT_VIEWER_NAME_MESSAGE = "\n결과를 보고 싶은 사람은?(quit를 입력시 반복 종료)";
    private static final String QUIT_MESSAGE = "quit";

    private final InputValidator validator;
    private final Scanner scanner = new Scanner(System.in);

    public InputView(InputValidator inputValidator) {
        this.validator = inputValidator;
    }

    public List<String> inputNames() {
        System.out.println(INPUT_NAMES_MESSAGE);
        List<String> names = List.of(scanner.nextLine().split(NAME_DELIMITER));
        validateNames(names);
        return trimNames(names);
    }

    public List<String> inputResults() {
        System.out.println(INPUT_RESULTS_MESSAGE);
        List<String> results = List.of(scanner.nextLine().split(NAME_DELIMITER));
        return trimNames(results);
//        return new Results(mapToResult(trimNames(results)));
    }

    public InputRepeatableDTO inputResultViewersName(final List<String> allPlayersName) {
        System.out.println(INPUT_RESULT_VIEWER_NAME_MESSAGE);
        List<String> inputNames = List.of(scanner.nextLine().split(NAME_DELIMITER));

        List<String> names = trimNames(inputNames);

        if (inputNames.contains(QUIT_MESSAGE)) {
            return InputRepeatableDTO.unrepeatable(names);
        }
        if (inputNames.contains(VIEW_ALL_PLAYERS_MESSAGE)) {
            return InputRepeatableDTO.repeatable(allPlayersName);
        }

        return InputRepeatableDTO.repeatable(names);
    }

    private void validateNames(final List<String> names) {
        for (String name : names) {
            validator.validate(
                    new InputValidationRequest(
                            List.of(ValidateType.DUPLICATE_VALUE),
                            name
                    )
            );
        }
    }

    private List<String> trimNames(final List<String> names) {
        return names.stream()
                .map(String::trim)
                .collect(Collectors.toUnmodifiableList());
    }

    public int inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT_MESSAGE);
        String input = scanner.nextLine();
        validator.validate(
                new InputValidationRequest(
                        List.of(ValidateType.EMPTY_VALUE, ValidateType.INTEGER_VALUE),
                        input
                )
        );
        return Integer.parseInt(input);
    }

    public LadderParameter inputLadder(int inputNameSize) {
        int height = inputLadderHeight();
        int width = inputNameSize - 1;
        return new LadderParameter(height, width);
    }

}
