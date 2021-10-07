import java.util.ArrayList;

public class TreeMap {
    TreeMapNode topNode = null;
    // 동적 ArrayList 선언
    public ArrayList<Object> treeNodeStack = new ArrayList<>();

    public void add(Comparable key, Object value) {
        if(topNode == null)
            topNode = new TreeMapNode(key, value);
        else
            topNode.add(key, value);
    }

    public Object get(Comparable key) {
        return topNode == null ? null : topNode.find(key);
    }
    // 모든 node의 itsValue를 받아오는 메서드
    public ArrayList visitAll() {
        // topNode가 null이 아닐 때 실행
        if (topNode != null) {
            // 최상위 Node와 값을 itsValue를 저장할 스택을 보낸다
            return topNode.findAll(topNode, treeNodeStack);
        }
        // topNode가 null일 때 null return
        else return null;
    }
}

class TreeMapNode {
    private final static int LESS = 0;
    private final static int GREATER = 1;
    private Comparable itsKey;
    private Object itsValue;
    private TreeMapNode nodes[] = new TreeMapNode[2];

    public TreeMapNode(Comparable key, Object value) {
        itsKey = key;
        itsValue = value;
    }

    public Object find(Comparable key) {
        if(key.compareTo(itsKey) == 0)
            return itsValue;
        return findSubNodeForKey(selectSubNode(key), key);
    }
    // 값을 전부 찾아 ArrayList에 저장하는 메서드
    public ArrayList findAll(TreeMapNode node, ArrayList treeMapNode) {
        // 현재 node가 null이 아닐 때 실행
        if(node != null) {
            // 현재 node의 itsValue 값을 ArrayList에 add
            treeMapNode.add(node.itsValue);
            // 왼쪽 노드 부터 재귀한다
            findAll(node.nodes[0], treeMapNode);
            findAll(node.nodes[1], treeMapNode);
        }
        // 현재의 node가 null일 때 또는 if문의 실행이 끝났을 때 ArrayList 저장 값만 return
        return treeMapNode;
    }

    private int selectSubNode(Comparable key) {
        return (key.compareTo(itsKey) < 0) ? LESS : GREATER;
    }

    private Object findSubNodeForKey(int node, Comparable key) {
        return nodes[node] == null ? null : nodes[node].find(key);
    }

    public void add(Comparable key, Object value) {
        if(key.compareTo(itsKey) == 0)
            itsValue = value;
        else
            addSubNode(selectSubNode(key), key, value);
    }

    private void addSubNode(int node, Comparable key, Object value) {
        if(nodes[node] == null)
            nodes[node] = new TreeMapNode(key, value);
        else
            nodes[node].add(key, value);
    }
}
