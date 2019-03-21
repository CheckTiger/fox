package cn.sxh.fox;

interface ISecurityCenter{
    String encrypt(String content);
    String decrypt(String password);
}