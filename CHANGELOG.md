# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2026.11.26

### Added

- Designed abstract class for Matrix component
- Implemented all secondary and common methods using only kernel and Standard methods

## 2026.11.25

### Added

- Designed kernel and enhanced interfaces for Matrix component

### Updated

- Changed design so matrix multiplication updates `this` instead of returning
  a new matrix as it did in the proof of concept. Now is void instead of return type Matrix
- Changed design to rename `add` and `multiply` to `matrixAddition` and
  `matrixMultiplication` for clarity
- Changed the design to include `setDimensions` in the kernel
- Changed the design to include `matrixSubtraction`, `scalarMultiplication`, `transpose`, `determinant`, `isSquare`, and `isSymmetric` as secondary methods

## 2026.11.23

### Added

- Designed a SnowbaordRider component
- Designed a Matrix component
- Designed a WorkoutLog component