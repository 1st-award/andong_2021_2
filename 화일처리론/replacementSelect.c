#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0

// input�� ������ �Ϻθ� Buffer ��´�
void readForm(int *Buffer, int input[], int i) {
    // printf("readForm: Buffer: %p input[%d]: %d\n", Buffer, i, input[i]);
    // printf("readForm Before : %d\n", *Buffer, input[i]);
    *Buffer = input[i];
    // printf("readForm After : %d\n", *Buffer, input[i]);
}
// �������� EOF�� �Ͼ�� �ʾҴ��� üŷ
int end_of_file(int input[], int n, int lastKey) {
    // printf("EOF: %d lastKey: %d\n", input[n-1], lastKey);
    // printf("end_of_file? %d\n", input[n - 1] == lastKey ? TRUE : FALSE);
    return input[n - 1] == lastKey ? TRUE : FALSE;
}
// ���ۿ��� ���� ���� Ű ���
int* smallestFrozen(int Buffer[], int m, int frozen[]) {
    int *arr = calloc(2, sizeof(int));
    int min = 9999, index = 0;
    for (int i = 0; i < m; ++i)
        // Buffer���� frozen���� �ʰ� ���� ���� �ε��� ���
        if (!frozen[i] && Buffer[i] < min) {
            min = Buffer[i];
            index = i;
        }
    // printf("min: %d index: %d\n", min, index);
    // ���� ���� ���� �ε��� ��ȣ return
    arr[0] = min;   arr[1] = index;
    return arr;
}
// ������ Ű���� ��� �������� Ȯ��
int isAllFrozen(int frozen[], int m) {
    for (int i = 0; i < m; ++i)
        // ������ �ϳ��� ������ FALSE
        if (!frozen[i])
            return FALSE;
    return TRUE;
}
// ���� �� Ű �� �߰�
// �� ���� �ִ� ũ�� 20
int arr[20];
// ���� �� �ε��� ��ȣ   
int run_index = 0;
// �� ���� ��ȣ
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
        // �迭 �ʱ�ȭ
        for (int j = 0; j < 20; ++j)
            arr[j] = 0;
        // �� �ε��� ��ȣ �ʱ�ȭ
        run_index = 0;
        number++;
    }
    // printf("==== RunFileEnd ====\n");
}

void replacementSelection(int _input[], int n) {
    const int m = 5; // ���ۿ� ���� ���ڵ� ��
    int *Buffer = calloc(m, sizeof(int)); // ����-���ڵ� �迭
    int *written = calloc(m, sizeof(int)); // �ش� ���� ���ڵ尡 ��µǾ������� ��Ÿ���� ������ �迭
    int *frozen = calloc(m, sizeof(int)); // �ش� ���� ���ڵ尡 ����Ǿ������� ��Ÿ���� �÷��� �迭
    int lastKey; // ���������� ���� ��µ� ���ڵ� Ű ��
    int* input = _input; // �Է� ȭ��
    int i; // �ݺ��� �ε���
    int s = 0; // ���� ���� �ε���
    int c = 0; // ���������� ���ۿ� �ε�� �ε��� ����
    // written TRUE �ʱ�ȭ
    for (i = 0; i < m; ++i)
        written[i] = TRUE; // true
    // ȭ���� EOF���� ���ų� Buffer�� �� á���� ���� �ݺ�
    i = 0;
    do {
        readForm(&Buffer[i], input, i);
        written[i] = FALSE; // false
        i++;    c++;
    } while (!end_of_file(input, n, Buffer[i]) && i != m);
    lastKey = input[c-1];
    // ���� ����
    //printf("=== Last C ===\n c -> %d %d\n", c, input[c]);
    while (!end_of_file(input, n, lastKey)) {
        // ���ο� �� �ϳ��� ����
        // ���� �÷��� �ʱ�ȭ
        for (i = 0; i < m; ++i)
            if (!written[i])
                frozen[i] = FALSE; // false
        // ������� ���� ���ڵ带 ���
        while (!isAllFrozen(frozen, m)) {
            // ���ۿ��� ���� ���� ���� ���� ��� Arr[0]: min, Arr[1]: indexNumber
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
        // ���� ������� �˸�
        appendToRun(0, 0);
    }
    // ���ۿ� �ִ� ������ Ű�鳢�� �����Ͽ� �� ����
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
    // ���ĵ� ���۸� Run�� ����
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
