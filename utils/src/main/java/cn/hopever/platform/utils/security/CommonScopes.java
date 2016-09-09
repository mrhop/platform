package cn.hopever.platform.utils.security;

/**
 * Created by Donghui Huo on 2016/9/9.
 */
//include internal_client and outer_client
public enum CommonScopes {
    internal_client, outer_client;

    public static void main(String[] args) {
        for (CommonScopes s : CommonScopes.values()) {
            System.out.println(s.name());//这是正常的场景
        }
    }
}
