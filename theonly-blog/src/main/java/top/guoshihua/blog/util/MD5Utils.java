package top.guoshihua.blog.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.UUID;

/**
 * @ClassName MD5Utils
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/3 0003 下午 7:08
 * @Version V1.0
 * @See 版权声明
 **/
public class MD5Utils {

    /**
     * shiro.crypto.hash.Md5Hash
     * Md5Hash继承SimpleHash。能使用Md5Hash的地方就能够使用SimpleHash。只用看2个类的构造器就可以明白它们的关系
     * Hex/Base64
     *         再者就是SimpleHash的 toString() toHex() toBase64() 3个方法的关系。
     *         它们与 HashedCredentialsMatcher 的 storedCredentialsHexEncoded 字段是对应的。
     */

    /**
     * SimpleHash 加密
     * @param password
     * @param salt
     * @return
     */
    public static final String simpleMD5Hash(String password, String salt){
        //加密方式
        String hashAlgorithmName = "MD5";
        //盐：为了即使相同的密码不同的盐加密后的结果也不同
        ByteSource byteSalt = ByteSource.Util.bytes(salt);
        //密码
        Object source = password;
        //加密次数
        int hashIterations = 1024;
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, source, byteSalt, hashIterations);
        return simpleHash.toString();
    }

    /**
     * md5加密
     * @param password
     * @param salt
     * @return
     */
    public static final String md5Hash(String password, String salt){
        ByteSource byteSalt = ByteSource.Util.bytes(salt);
        int hashIterations = 1024;
        Md5Hash md5Hash = new Md5Hash(password, byteSalt, hashIterations);
        return md5Hash.toString();
    }

    /**
     * 随机生产盐salt （UUID）
     */
    public static String generateSalt(){
        return StringUtils.replace(UUID.randomUUID().toString(), "-", "");
    }
}
