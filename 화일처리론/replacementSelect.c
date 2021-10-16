#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0
#define MAX 20

// input된 프레임 일부를 Buffer 담는다
void setReadForm(int *Buffer, int input[], int i) {
    *Buffer = input[i];
}

// 프레임이 EOF가 일어나지 않았는지 체킹
int isEndOfFile(int input[], int n, int lastKey) {
    return input[n - 1] == lastKey ? TRUE : FALSE;
}

// 버퍼에서 가장 작은 키 출력
int* getSmallestFrozen(int Buffer[], int m, int frozen[]) {
    int *arr = calloc(2, sizeof(int));
    int min = 9999, index = 0;
    for (int i = 0; i < m; ++i)
        // Buffer에서 frozen되지 않고 가장 작은 인덱스 출력
        if (!frozen[i] && Buffer[i] < min) {
            min = Buffer[i];
            index = i;
        }
    // 가장 작은 값과 인덱스 번호 return
    arr[0] = min;   arr[1] = index;
    return arr;
}

// 버퍼의 키들이 모두 동결인지 확인
int isAllFrozen(int frozen[], int m) {
    for (int i = 0; i < m; ++i)
        // 동결이 하나라도 없으면 FALSE
        if (!frozen[i])
            return FALSE;
    return TRUE;
}

// 런 파일 최대 크기
int run_file[MAX][MAX];
// 현재 런 인덱스 번호
int run_index_row = 0;
int run_index_column = 0;
// 런에 들어갈 키 값 추가 (status 1: 버퍼에서 작은 레코드를 정렬된 화일에 추가 0: 초기화)
void setAppendToRun(int key, int status) {
    if (status)
            run_file[run_index_row][run_index_column++] = key;
    else {
        // 런 인덱스 번호 초기화
        run_index_column = 0;
        run_index_row++;
    }
}

// 버퍼에 있던 나머지 키들끼리 정렬하여 런 생성
void setSortBuffer(int Buffer[], int m, int lastKey) {
    for (int i = 0; i < m; ++i) {
        for (int j = i + 1; j < m; ++j) {
            if (lastKey == Buffer[i])
                break;
            else if (Buffer[i] > Buffer[j]) {
                Buffer[j] = Buffer[j] ^ Buffer[i];
                Buffer[i] = Buffer[i] ^ Buffer[j];
                Buffer[j] = Buffer[j] ^ Buffer[i];
            }
        }
    }
}

// 정렬된 런 보기
void viewRunFile() {
    for (int i = 0; i < MAX; i++) {
        if (!run_file[i][0])
            break;
        printf("런 %d: ", i + 1);
        for (int j = 0; j < MAX; j++) {
            if (!run_file[i][j])
                break;
            printf("%3d ", run_file[i][j]);
        }
        puts("");
    }
}

void replacementSelection(int _input[], int n) {
    const int m = 5; // 버퍼에 들어가는 레코드 수
    int *Buffer = calloc(m, sizeof(int)); // 버퍼-레코드 계열
    int *written = calloc(m, sizeof(int)); // 해당 버퍼 레코드가 출력되었는지를 나타내는 프래그 배열
    int *frozen = calloc(m, sizeof(int)); // 해당 버퍼 레코드가 동결되었는지를 나타내는 플래그 배열
    int lastKey; // 마지막으로 런에 출력된 레코드 키 값
    int* input = _input; // 입력 화일
    int i; // 반복문 인덱스
    int s = 0; // 버퍼 현재 인덱스
    int c = 0; // 마지막으로 버퍼에 로드된 인덱스 개수
    // written TRUE 초기화
    for (i = 0; i < m; ++i)
        written[i] = TRUE; // true
    // 화일이 EOF까지 갔거나 Buffer가 다 찼을때 까지 반복
    i = 0;
    do {
        setReadForm(&Buffer[i], input, i);
        written[i] = FALSE; // false
        i++;    c++;
    } while (!isEndOfFile(input, n, Buffer[i]) && i != m);
    lastKey = input[c-1];
    // 런의 생성
    while (!isEndOfFile(input, n, lastKey)) {
        // 새로운 런 하나를 생성
        // 동결 플래그 초기화
        for (i = 0; i < m; ++i)
            if (!written[i])
                frozen[i] = FALSE; // false
        // 동결되지 않은 레코드를 출력
        while (!isAllFrozen(frozen, m)) {
            // 버퍼에서 가장 작은 값을 런에 출력 Arr[0]: min, Arr[1]: indexNumber
            int *smallArr = getSmallestFrozen(Buffer, m, frozen);
            int min = smallArr[0];
            int indexNumber = smallArr[1];
            setAppendToRun(min, 1);
            lastKey = min;
            written[indexNumber] = TRUE;
            frozen[indexNumber] = TRUE;
            // 파일이 EOF까지 갔는지 확인
            if (!isEndOfFile(input, n, lastKey)) {
                setReadForm(&Buffer[indexNumber], input, c++);
                written[indexNumber] = FALSE;
                // 마지막에 정렬된 화일에 넣은 레코드와 방금 버퍼에 새로 넣은 레코드를 비교해서 새로 넣은 레코드가 크면 동결 해제
                if (Buffer[indexNumber] > lastKey)
                    frozen[indexNumber] = FALSE;
            }
        }
        // 런이 종료됨을 알림
        setAppendToRun(0, 0);
    }

    // 버퍼에 있는 남은 레코드를 새로운 런에 삽입
    setSortBuffer(Buffer, m, lastKey);

    // 정렬된 버퍼를 Run에 삽입
    for (int i = 0; i < m; ++i) {
        if(lastKey != Buffer[i])
            setAppendToRun(Buffer[i], 1);
    }
    setAppendToRun(0, 0);
}

int main(void) {
    int arr[] = {109, 49, 34, 68, 45, 2, 60, 38, 28, 47, 16, 19, 34, 55, 98, 78, 76, 40, 35, 86, 10, 27, 61, 92, 99, 72, 11, 2, 29, 16, 80, 73, 18, 12, 89, 50, 46, 36, 67, 93, 22, 14, 83, 44, 52, 59, 10, 38, 76, 16, 24, 85};
    replacementSelection(arr, 52);
    viewRunFile();
    return 0;
}
