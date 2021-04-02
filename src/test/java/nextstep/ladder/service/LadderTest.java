package nextstep.ladder.service;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("Ladder 생성 시 Height 일치 테스트")
    @Test
    void create_생성_테스트() {
        // given
        Participants participants = Participants.valueOf("12345,1234");
        Height height = Height.valueOf(2);
        // when
        List<Line> ladder = Ladder.valueOf(participants, height).lines();
        int expected = Height.valueOf(2).size();
        // then
        assertThat(ladder.size()).isEqualTo(expected);
    }
}
