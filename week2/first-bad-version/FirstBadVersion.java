public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                // mid is bad, so the first bad version is
                // mid or somewhere to the left.
                right = mid;
            } else {
                // mid is good, so the first bad version
                // must be to the right.
                left = mid + 1;
            }
        }

        return left;
    }
}