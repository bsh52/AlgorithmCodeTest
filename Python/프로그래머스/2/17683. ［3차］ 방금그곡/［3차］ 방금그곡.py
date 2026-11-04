def solution(m, musicinfos):
    answer = "(None)"
    m = change_sharp(m)
    max_play_time = 0

    for music in musicinfos:
        start_time, end_time, music_name, music_lyrics = music.split(",")
        music_lyrics = change_sharp(music_lyrics)
        play_time = transfer_time(end_time) - transfer_time(start_time)

        full_lyrics = (music_lyrics * (play_time // len(music_lyrics) + 1))[:play_time]

        if play_time > max_play_time and m in full_lyrics:
            max_play_time = play_time
            answer = music_name

    return answer


def change_sharp(s):
    return (
        s.replace("C#", "c")
        .replace("D#", "d")
        .replace("F#", "f")
        .replace("G#", "g")
        .replace("A#", "a")
    )


def transfer_time(time):
    h, m = map(int, time.split(":"))
    return h * 60 + m