package utils;

public final class TestDataFactory {
    private TestDataFactory() {}
    public static int uniquePetId() {
// 9xxxxx range to avoid collisions with common demo ids
        long ts = System.currentTimeMillis() % 1_000_000;
        return (int) (900_000 + ts);
    }
}