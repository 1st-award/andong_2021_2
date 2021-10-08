#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0

// input된 프레임 일부를 Buffer 담는다
void readForm(int *Buffer, int input[], int i) {
    // printf("readForm: Buffer: %p input[%d]: %d\n", Buffer, i, input[i]);
    // printf("readForm Before : %d\n", *Buffer, input[i]);
    *Buffer = input[i];
    // printf("readForm After : %d\n", *Buffer, input[i]);
}
// 프레임이 EOF가 일어나지 않았는지 체킹
int end_of_file(int input[], int n, int lastKey) {
    // printf("EOF: %d lastKey: %d\n", input[n-1], lastKey);
    // printf("end_of_file? %d\n", input[n - 1] == lastKey ? TRUE : FALSE);
    return input[n - 1] == lastKey ? TRUE : FALSE;
}
// 버퍼에서 가장 작은 키 출력
int* smallestFrozen(int Buffer[], int m, int frozen[]) {
    int *arr = calloc(2, sizeof(int));
    int min = 9999, index = 0;
    for (int i = 0; i < m; ++i)
        // Buffer에서 frozen되지 않고 가장 작은 인덱스 출력
        if (!frozen[i] && Buffer[i] < min) {
            min = Buffer[i];
            index = i;
        }
    // printf("min: %d index: %d\n", min, index);
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
// 런에 들어갈 키 값 추가
// 런 파일 최대 크기 20
int arr[20];
// 현재 런 인덱스 번호   
int run_index = 0;
// 런 파일 번호
int number = 1;
void appendToRun(int key, int status) {
    // printf("key: %d status: %d\n", key, status);
    // printf("==== RunFile %d ====\n", number);
    if (status) {
            arr[run_index++] = key;
            /*
            for (int j = 0; j < 20; ++j) {
                if (!arr[j])
                    break;
                else printf("%d ", arr[j]);
            }
            puts("");
            */
    }
    else {
        printf("==== RunFile %d ====\n", number);
        for (int j = 0; j < 20; ++j) {
            if (!arr[j])
                break;
            else printf("%d ", arr[j]);
        }
        puts("");
        // 배열 초기화
        for (int j = 0; j < 20; ++j)
            arr[j] = 0;
        // 런 인덱스 번호 초기화
        run_index = 0;
        number++;
    }
    // printf("==== RunFileEnd ====\n");
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
        readForm(&Buffer[i], input, i);
        written[i] = FALSE; // false
        i++;    c++;
    } while (!end_of_file(input, n, Buffer[i]) && i != m);
    lastKey = input[c-1];
    // 런의 생성
    //printf("=== Last C ===\n c -> %d %d\n", c, input[c]);
    while (!end_of_file(input, n, lastKey)) {
        // 새로운 런 하나를 생성
        // 동결 플래그 초기화
        for (i = 0; i < m; ++i)
            if (!written[i])
                frozen[i] = FALSE; // false
        // 동결되지 않은 레코드를 출력
        while (!isAllFrozen(frozen, m)) {
            // 버퍼에서 가장 작은 값을 런에 출력 Arr[0]: min, Arr[1]: indexNumber
            int *smallArr = smallestFrozen(Buffer, m, frozen);
            int min = smallArr[0];
            int indexNumber = smallArr[1];
            appendToRun(min, 1);
            lastKey = min;
            written[indexNumber] = TRUE;
            frozen[indexNumber] = TRUE;
            if (!end_of_file(input, n, lastKey)) {
                // printf("ABC: %d %d\n", Buffer[indexNumber], c);
                readForm(&Buffer[indexNumber], input, c++);
                // printf("readForm: %d\n", Buffer[indexNumber]);
                written[indexNumber] = FALSE;
                if (Buffer[indexNumber] > lastKey)
                    frozen[indexNumber] = FALSE;
            }
        }
        // 런이 종료됨을 알림
        appendToRun(0, 0);
    }
    // 버퍼에 있던 나머지 키들끼리 정렬하여 런 생성
    for (int i = 0; i < m; ++i) {
        for (int j = i+1; j < m; ++j) {
            if (lastKey == Buffer[i])
                break;
            else if (Buffer[i] > Buffer[j]) {
                Buffer[j] = Buffer[j] ^ Buffer[i];
                Buffer[i] = Buffer[i] ^ Buffer[j];
                Buffer[j] = Buffer[j] ^ Buffer[i];   
            }
        }
    }
    // 정렬된 버퍼를 Run에 삽입
    for (int i = 0; i < m; ++i) {
        if(lastKey != Buffer[i])
            appendToRun(Buffer[i], 1);
    }
    appendToRun(0, 0);
}

int main(void) {
    int arr[] = {109, 49, 34, 68, 45, 2, 60, 38, 28, 47, 16, 19, 34, 55, 98, 78, 76, 40, 35, 86, 10, 27, 61, 92, 99, 72, 11, 2, 29, 16, 80, 73, 18, 12, 89, 50, 46, 36, 67, 93, 22, 14, 83, 44, 52, 59, 10, 38, 76, 16, 24, 85};
    replacementSelection(arr, 52);
    return 0;
}
