import os
import pyautogui
import time
import webbrowser

URL = 'http://dorm.andong.ac.kr/etrappl/chk_self_cond.php'
CHROME_PATH = 'C:/Program Files/Google/Chrome/Application/chrome.exe %s'

confirm = pyautogui.confirm("조금이라도 몸에 이상이 있으면 실행하지 마세요!\n책임은 당신에게 있습니다.")
if confirm == "OK":
    first_user = pyautogui.confirm("프로그램이 처음이신가요?")
    if first_user == "OK":
        student_id = pyautogui.prompt("학번을 입력하세요.")
        date_of_birth = pyautogui.prompt("생년월일을 입력하세요.")
        password = pyautogui.prompt("비밀번호를 입력하세요.")
        try:
            os.mkdir("C:/jagajindan")
        except FileExistsError:
            pass
        file = open("C:/jagajindan/latest.txt", 'w')
        for temp in student_id, date_of_birth, password:
            temp = temp + "\n"
            file.write(temp)
        file.close()
    else:
        file = open("C:/jagajindan/latest.txt")
        info = file.readlines()
        file.close()
        # Remove new line
        for temp in info:
            temp = temp.strip()
        student_id, date_of_birth, password = info

    print("URL OPEN")
    # Login
    webbrowser.get(CHROME_PATH).open(URL)
    time.sleep(3)
    pyautogui.hotkey("F11")
    pyautogui.typewrite(student_id, interval=0.01)
    time.sleep(0.1)
    pyautogui.hotkey("enter")
    pyautogui.typewrite(date_of_birth, interval=0.01)
    time.sleep(0.1)
    pyautogui.hotkey("enter")
    pyautogui.typewrite(password, interval=0.01)
    # Login End
    # Self-diagnosis based on 4k
    time.sleep(0.3)
    pyautogui.leftClick(x=989, y=876)
    pyautogui.leftClick(x=1935, y=873)
    pyautogui.leftClick(x=1950, y=1063)
    pyautogui.leftClick(x=984, y=1057)
    pyautogui.leftClick(x=991, y=1199)
    pyautogui.hotkey("enter")
    time.sleep(0.1)
    pyautogui.hotkey("enter")
    time.sleep(0.1)
    pyautogui.hotkey("enter")
    # Self-diagnosis End
    pyautogui.alert("작업이 완료되었습니다!")
