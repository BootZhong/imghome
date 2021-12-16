package top.bootzhong.imghome.util;

import org.springframework.lang.Nullable;

/**
 * 文件工具类
 * @author bootzhong
 */
public class FileUtil {

    public static String getSuffix(@Nullable String filename){
        assert filename != null && !"".equals(filename);
        String[] split = filename.split("\\.");
        return split.length > 1 ? "." + split[split.length - 1] : "";
    }
}
