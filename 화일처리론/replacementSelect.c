#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0
#define MAX 20

// input�� ������ �Ϻθ� Buffer ��´�
void setReadForm(int *Buffer, int input[], int i) {
    *Buffer = input[i];
}

// �������� EOF�� �Ͼ�� �ʾҴ��� üŷ
int isEndOfFile(int input[], int n, int lastKey) {
    return input[n - 1] == lastKey ? TRUE : FALSE;
}

// ���ۿ��� ���� ���� Ű ���
int* getSmallestFrozen(int Buffer[], int m, int frozen[]) {
    int *arr = calloc(2, sizeof(int));
    int min = 9999, index = 0;
    for (int i = 0; i < m; ++i)
        // Buffer���� frozen���� �ʰ� ���� ���� �ε��� ���
        if (!frozen[i] && Buffer[i] < min) {
            min = Buffer[i];
            index = i;
        }
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

// �� ���� �ִ� ũ��
int run_file[MAX][MAX];
// ���� �� �ε��� ��ȣ
int run_index_row = 0;
int run_index_column = 0;
// ���� �� Ű �� �߰� (status 1: ���ۿ��� ���� ���ڵ带 ���ĵ� ȭ�Ͽ� �߰� 0: �ʱ�ȭ)
void setAppendToRun(int key, int status) {
    if (status)
            run_file[run_index_row][run_index_column++] = key;
    else {
        // �� �ε��� ��ȣ �ʱ�ȭ
        run_index_column = 0;
        run_index_row++;
    }
}

// ���ۿ� �ִ� ������ Ű�鳢�� �����Ͽ� �� ����
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

// ���ĵ� �� ����
void viewRunFile() {
    for (int i = 0; i < MAX; i++) {
        if (!run_file[i][0])
            break;
        printf("�� %d: ", i + 1);
        for (int j = 0; j < MAX; j++) {
            if (!run_file[i][j])
                break;
            printf("%3d ", run_file[i][j]);
        }
        puts("");
    }
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
        setReadForm(&Buffer[i], input, i);
        written[i] = FALSE; // false
        i++;    c++;
    } while (!isEndOfFile(input, n, Buffer[i]) && i != m);
    lastKey = input[c-1];
    // ���� ����
    while (!isEndOfFile(input, n, lastKey)) {
        // ���ο� �� �ϳ��� ����
        // ���� �÷��� �ʱ�ȭ
        for (i = 0; i < m; ++i)
            if (!written[i])
                frozen[i] = FALSE; // false
        // ������� ���� ���ڵ带 ���
        while (!isAllFrozen(frozen, m)) {
            // ���ۿ��� ���� ���� ���� ���� ��� Arr[0]: min, Arr[1]: indexNumber
            int *smallArr = getSmallestFrozen(Buffer, m, frozen);
            int min = smallArr[0];
            int indexNumber = smallArr[1];
            setAppendToRun(min, 1);
            lastKey = min;
            written[indexNumber] = TRUE;
            frozen[indexNumber] = TRUE;
            // ������ EOF���� ������ Ȯ��
            if (!isEndOfFile(input, n, lastKey)) {
                setReadForm(&Buffer[indexNumber], input, c++);
                written[indexNumber] = FALSE;
                // �������� ���ĵ� ȭ�Ͽ� ���� ���ڵ�� ��� ���ۿ� ���� ���� ���ڵ带 ���ؼ� ���� ���� ���ڵ尡 ũ�� ���� ����
                if (Buffer[indexNumber] > lastKey)
                    frozen[indexNumber] = FALSE;
            }
        }
        // ���� ������� �˸�
        setAppendToRun(0, 0);
    }

    // ���ۿ� �ִ� ���� ���ڵ带 ���ο� ���� ����
    setSortBuffer(Buffer, m, lastKey);

    // ���ĵ� ���۸� Run�� ����
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
